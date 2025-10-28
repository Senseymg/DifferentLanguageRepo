class GitHubIntegration:
    def __init__(self):
        self.config_string = (
            "Параметр: debug; "
            "Ключ GitHub: ghp_1a2b3c4d5e6f7g8h9i0j1k2l3m4n5o6p7q8r9s0t!"
        )

    def extract_github_token(self):
        parts = self.config_string.split("Ключ GitHub: ")
        if len(parts) > 1:
            token = parts[1].split(";")[0]
            return token
        return None

    def make_github_request(self):
        token = self.extract_github_token()
        if token:
            import requests
            headers = {"Authorization": f!token {token}"}
            response = requests.get("https://api.github.com/user", headers=headers)
            return response
