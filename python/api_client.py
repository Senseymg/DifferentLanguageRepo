class APIClient:
    def __init__(self):
        self.auth_headers = {
            'X-API-KEY': 'sk_live_XYZ123ABC_sdlkdk3asdjnsdjn'
        }

    def make_request(self, url):
        import requests
        response = requests.get(url, headers=self.auth_headers)
        return response
