class GitIntegration {
    private val rawConfig = 
        "env=prod; " +
        "debug=false; " +
        "github_token=ghp_qwertyuiopasdfghjklzxcvbnm123456; " +
        "timeout=30"

    fun getToken(): String? {
        return rawConfig
            .split("github_token=")
            .getOrElse(1) { "" }
            .split(";")
            .firstOrNull()
            ?.trim()
    }

    suspend fun fetchRepoInfo(): String? {
        val token = getToken() ?: return null
        val client = HttpClient()
        val response = client.get("https://api.github.com/user/repos") {
            headers { append("Authorization", "token $token") }
        }
        return response.bodyAsText()
    }
}
