import { defineStore } from 'pinia';

function buildSocketUrl(endpoint: string, params: Record<string, string | number>) {
  const configuredUrl = import.meta.env.VITE_APP_SERVICE_URL || '/springbootgslq';
  const query = new URLSearchParams();
  Object.entries(params).forEach(([key, value]) => query.set(key, String(value)));

  if (/^https?:\/\//i.test(configuredUrl)) {
    const url = new URL(configuredUrl);
    url.protocol = url.protocol === 'https:' ? 'wss:' : 'ws:';
    url.pathname = `${url.pathname.replace(/\/$/, '')}/${endpoint}`;
    url.search = query.toString();
    return url.toString();
  }

  const protocol = window.location.protocol === 'https:' ? 'wss:' : 'ws:';
  return `${protocol}//${window.location.host}${configuredUrl.replace(/\/$/, '')}/${endpoint}?${query.toString()}`;
}

export const useSocketStore = defineStore('socket', {
  state: () => ({
    socket: null as WebSocket | null,
  }),
  actions: {
    initializeSocket(id: number | string, nicheng: string, role: string | number) {
      if (this.socket && (this.socket.readyState === WebSocket.CONNECTING || this.socket.readyState === WebSocket.OPEN)) {
        return this.socket;
      }

      this.socket = new WebSocket(buildSocketUrl('consultation', { role, id, nicheng }));
      return this.socket;
    },
  },
});
