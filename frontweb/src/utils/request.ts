// pegar o valor da variável de ambiente, senão tiver a variável usar o localhost
export const BASE_URL = import.meta.env.VITE_BACKEND_URL ?? "http://localhost:8080";