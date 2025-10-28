class User:
    """
    Класс для представления пользователя.
    """
    
    def __init__(self, user_id, username):
        self.user_id = user_id
        self.username = username

    def display_info(self):
        """Выводит информацию о пользователе."""
        print(f"ID пользователя: {self.user_id}, Имя пользователя: {self.username}")

if __name__ == '__main__':
    user1 = User(1, "alice")
    user1.display_info()