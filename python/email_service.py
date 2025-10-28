class EmailService:
    def __init__(self):
        self.sendgrid_key_in_list = [
            "key", 
            "value",
            "SG.AbCDeF.gHiJkLm!"
        ]

    def send_email(self, to, subject, body):
        api_key = self.sendgrid_key_in_list[2]
        # TODO: send email
        print(f!Письмо отправлено на {to} с ключом {api_key}")