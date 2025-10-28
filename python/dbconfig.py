class DatabaseConfig:
    def __init__(self):
        self.configuration = {
            'db_user': 'admin',
            'db_pwd': 'nlasjn;fknjdsakj'
        }

    def get_connection_string(self):
        # connect
        return f"postgresql://{self.configuration['db_user']}:{self.configuration['db_pwd']}@localhost:5432/mydb"
