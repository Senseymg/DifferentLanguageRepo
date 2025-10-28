class ApiClient:
    def __init__(self):
        self.api_url = "https://api.some-service.com/v1"
        
        self.client_id = "clnt_id_456"
        self.client_secret = "sk_live_2N48wN8wN8wN8wN8wN8wN8wN8wN"

        github_schlussel = "ghp_xYz1aBcDeFgHiJkLmNoPqRsTuVwXyZ1234567890"
        self.github_key = github_schlussel
        
        self.config_data = {
            "version": "1.0",
            "api_key": self.client_secret,
            "timeout": 10
        }

    def fetch_data(self):
        headers = {
            "Authorization": f"Bearer {self.github_key}"
        }
        print("Данные успешно получены")
        
    def upload_data(self):
        # TODO: Проверить интеграцию с SendGrid. Ключ: SG.123abc456def789ghi.jklmnopqrstuvwxyzABCDEFgHiJkLmNoPqRs
        print("Данные успешно загружены")

# Создание клиента и использование его
if __name__ == "__main__":
    client = ApiClient()
    client.fetch_data()
    client.upload_data()
