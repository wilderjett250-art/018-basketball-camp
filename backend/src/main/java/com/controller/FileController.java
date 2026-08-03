package com.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.ConfigEntity;
import com.entity.EIException;
import com.service.ConfigService;
import com.utils.R;

/**
 * 上传文件映射表
 */
@RestController
@RequestMapping("file")
@SuppressWarnings({"unchecked","rawtypes"})
public class FileController{
	@Autowired
	private ConfigService configService;
	@Value("${PROJECT_NAME:defaultProject}")
	private String projectName;

	/**
	 * 上传文件
	 */
	// /usr/images/" + session.getProjectName() + "/upload
	@IgnoreAuth
	@RequestMapping("/upload")
	public R upload(@RequestParam("file") MultipartFile file,String type) throws Exception {
		try {
			System.out.println("=== 文件上传流程开始 ===");
			System.out.println("1. 文件检查阶段");

			if (file.isEmpty()) {
				System.out.println("❌ 文件为空，抛出异常");
				throw new EIException("上传文件不能为空");
			}

			System.out.println("✅ 文件检查通过");
			System.out.println("原始文件名: " + file.getOriginalFilename());
			System.out.println("文件大小: " + file.getSize() + " bytes");

			String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
			System.out.println("文件扩展名: " + fileExt);

			System.out.println("2. 路径确定阶段");
			File path = null;
			if (isRunningInsideDocker()) {
				path = new File("/usr/images/" + projectName);
				System.out.println("🐳 Docker环境，使用路径: " + path.getAbsolutePath());
			} else {
				String staticPath = getStaticPath();
				path = new File(staticPath);
				System.out.println("💻 本地环境，使用路径: " + path.getAbsolutePath());
			}

			System.out.println("3. 基础路径检查");
			System.out.println("基础路径是否存在: " + path.exists());
			System.out.println("基础路径可写: " + path.canWrite());
			System.out.println("基础路径权限: " + getFilePermissions(path));

			if(!path.exists()) {
				System.out.println("📁 创建基础路径...");
				boolean created = path.mkdirs();
				System.out.println("基础路径创建结果: " + (created ? "成功" : "失败"));
				if (created) {
					System.out.println("创建后路径是否存在: " + path.exists());
					System.out.println("创建后路径可写: " + path.canWrite());
				}
			}

			System.out.println("4. 上传目录处理");
			File upload = new File(path.getAbsolutePath(), "/upload/");
			System.out.println("上传目录完整路径: " + upload.getAbsolutePath());
			System.out.println("上传目录是否存在: " + upload.exists());
			System.out.println("上传目录可写: " + upload.canWrite());

			if(!upload.exists()) {
				System.out.println("📂 创建上传目录...");
				boolean created = upload.mkdirs();
				System.out.println("上传目录创建结果: " + (created ? "成功" : "失败"));
				if (created) {
					System.out.println("创建后上传目录是否存在: " + upload.exists());
					System.out.println("创建后上传目录可写: " + upload.canWrite());
				}
			} else {
				System.out.println("📂 上传目录已存在，列出当前内容:");
				String[] existingFiles = upload.list();
				if (existingFiles != null) {
					for (String f : existingFiles) {
						System.out.println("   - " + f);
					}
				} else {
					System.out.println("   目录为空或无法访问");
				}
			}

			System.out.println("5. 文件保存阶段");
			String fileName = new Date().getTime()+"."+fileExt;
			System.out.println("生成文件名: " + fileName);

			File dest = new File(upload.getAbsolutePath()+"/"+fileName);
			System.out.println("目标文件完整路径: " + dest.getAbsolutePath());
			System.out.println("目标文件父目录可写: " + dest.getParentFile().canWrite());

			System.out.println("6. 开始文件传输...");
			try {
				file.transferTo(dest);
				System.out.println("✅ 文件传输完成");
			} catch (Exception e) {
				System.out.println("❌ 文件传输失败: " + e.getMessage());
				throw e;
			}

			System.out.println("7. 传输后验证");
			System.out.println("目标文件是否存在: " + dest.exists());
			System.out.println("目标文件大小: " + (dest.exists() ? dest.length() + " bytes" : "文件不存在"));
			System.out.println("目标文件可读: " + dest.canRead());
			System.out.println("目标文件可写: " + dest.canWrite());

			// 重新列出上传目录内容
			System.out.println("传输后上传目录内容:");
			String[] afterFiles = upload.list();
			if (afterFiles != null) {
				for (String f : afterFiles) {
					File checkFile = new File(upload, f);
					System.out.println("   - " + f + " (大小: " + checkFile.length() + " bytes)");
				}
			}

			System.out.println("8. 业务逻辑处理");
			if(StringUtils.isNotBlank(type) && type.equals("1")) {
				System.out.println("处理特殊类型文件配置...");
				ConfigEntity configEntity = configService.selectOne(new EntityWrapper<ConfigEntity>().eq("name", "faceFile"));
				if(configEntity==null) {
					configEntity = new ConfigEntity();
					configEntity.setName("faceFile");
					configEntity.setValue(fileName);
					System.out.println("创建新配置项");
				} else {
					configEntity.setValue(fileName);
					System.out.println("更新现有配置项");
				}
				configService.insertOrUpdate(configEntity);
				System.out.println("配置保存完成");
			}

			System.out.println("🎉 文件上传流程完成，返回文件名: " + fileName);
			System.out.println("=== 文件上传流程结束 ===\n");

			return R.ok().put("file", fileName);

		} catch (Exception e) {
			System.err.println("💥 文件上传异常: " + e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}

	// 添加辅助方法获取文件权限信息
	private String getFilePermissions(File file) {
		if (!file.exists()) {
			return "文件不存在";
		}
		StringBuilder permissions = new StringBuilder();
		permissions.append(file.canRead() ? "r" : "-");
		permissions.append(file.canWrite() ? "w" : "-");
		permissions.append(file.canExecute() ? "x" : "-");
		return permissions.toString();
	}

	/**
	 * 下载文件
	 */
	@IgnoreAuth
	@RequestMapping("/download")
	public ResponseEntity<byte[]> download(@RequestParam String fileName) {
		try {
			File path = new File(ResourceUtils.getURL("classpath:static").getPath());
			if(!path.exists()) {
				path = new File("");
			}
			File upload = new File(path.getAbsolutePath(),"/upload/");
			if(!upload.exists()) {
				upload.mkdirs();
			}
			File file = new File(upload.getAbsolutePath()+"/"+fileName);
			if(file.exists()){
				/*if(!fileService.canRead(file, SessionManager.getSessionUser())){
					getResponse().sendError(403);
				}*/
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.setContentDispositionFormData("attachment", fileName);
				return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.CREATED);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private String getStaticPath() throws IOException {
		return ResourceUtils.getFile("src/main/resources/static").getAbsolutePath();
	}

	private Boolean isRunningInsideDocker() {
		// 方法2: 检查 /proc/1/cgroup 文件
		try (Stream<String> stream = Files.lines(Paths.get("/proc/1/cgroup"))) {
			return stream.anyMatch(line -> line.contains("/docker") || line.contains("/ecs"));
		} catch (IOException e) {
			return false;
		}
	}


}
