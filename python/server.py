
server_tkn = "alksnjlslkkmadmkamkask!"


class ServerAuth:
    def check_token(self, token):
        # compare tokens
        return token == server_tkn
