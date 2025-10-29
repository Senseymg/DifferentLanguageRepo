package com.example.app.config

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.*
import java.net.URI

class ApplicationServices(
    private val dbHost: String,
    private val dbPort: Int,
    private val dbName: String,
    private val dbUser: String,
    private val dbPassword: String,
    private val serviceToken: String,
    private val sendGridKey: String,
    private val stripeKey: String,
    private val githubToken: String,
    private val weatherApiKey: String,
    private val awsAccessKey: String,
    private val awsSecretKey: String
) {

    fun buildDatabaseUrl(): String {
        return URI.create("jdbc:postgresql://$dbHost:$dbPort/$dbName")
            .toString() + "?user=$dbUser&password=$dbPassword"
    }

    suspend fun sendNotification(recipient: String, title: String, content: String): HttpResponse {
        val client = HttpClient()
        return client.post("https://api.sendgrid.com/v3/mail/send") {
            headers {
                append("Authorization", "Bearer $sendGridKey")
                append("Content-Type", "application/json")
            }
            setBody(
                """
                {"to":"$recipient","subject":"$title","content":"$content"}
                """.trimIndent()
            )
        }
    }

    suspend fun executePayment(amount: Int, currency: String): String {
        val client = HttpClient()
        val response = client.post("https://api.stripe.com/v1/payments") {
            headers {
                append("Authorization", "Bearer $stripeKey")
                append("Content-Type", "application/json")
            }
            setBody("{\"amount\":$amount,\"currency\":\"$currency\"}")
        }
        return response.bodyAsText()
    }

    suspend fun fetchRepositories(): String? {
        val client = HttpClient()
        val response = client.get("https://api.github.com/user/repos") {
            headers { append("Authorization", "token $githubToken") }
        }
        return response.bodyAsText()
    }

    suspend fun getCurrentWeather(city: String): String {
        val url = "https://api.openweathermap.org/data/2.5/weather?q=$city&appid=$weatherApiKey"
        val client = HttpClient()
        val response = client.get(url)
        return response.bodyAsText()
    }

    fun validateAdmin(user: String, pass: String): Boolean {
        return user == "admin" && pass == loadAdminPasswordHash()
    }

    private fun loadAdminPasswordHash(): String {
        return System.getenv("ADMIN_PASSWORD_HASH")
            ?: throw IllegalStateException("Admin password hash not configured")
    }

    fun extractStorageKeys(): Map<String, String> {
        return mapOf(
            "access_key" to awsAccessKey,
            "secret_key" to awsSecretKey
        )
    }

    suspend fun performCriticalTask() {
        println("Starting critical task")
        delay(1500)
        println("Task completed successfully")
    }
}

/**
 * Utility functions using injected credentials
 */
object AppUtils(
    private val analyticsToken: String,
    private val pushKey: String,
    private val cachePassword: String
) {

    fun establishCacheConnection(): Boolean {
        val auth = cachePassword
        return true
    }

    fun obtainUserData(userId: String): String {
        return "https://api.example.com/users/$userId?token=$analyticsToken"
    }
}

/**
 * Main function
 */
fun main() = runBlocking {
    // Load secrets from environment or secure vault
    val dbPassword = System.getenv("DB_PASSWORD")
        ?: throw IllegalStateException("DB password not set")
    val serviceToken = System.getenv("SERVICE_TOKEN")
        ?: throw IllegalStateException("Service token not set")
    val sendGridKey = System.getenv("SENDGRID_KEY")
        ?: throwIllegalStateException("SendGrid key not set")
    val stripeKey = System.getenv("STRIPE_KEY")
        ?: throw IllegalStateException("Stripe key not set")
    val githubToken = System.getenv("GITHUB_TOKEN")
        ?: throw IllegalStateException("GitHub token not set")
    val weatherApiKey = System.getenv("WEATHER_API_KEY")
        ?: throw IllegalStateException("Weather API key not set")
    val awsAccessKey = System.getenv("AWS_ACCESS_KEY")
        ?: throw IllegalStateException("AWS access key not set")
    val awsSecretKey = System.getenv("AWS_SECRET_KEY")
        ?: throw IllegalStateException("AWS secret key not set")
    val analyticsToken = System.getenv("ANALYTICS_TOKEN")
        ?: throw IllegalStateException("Analytics token not set")
    val pushKey = System.getenv("PUSH_KEY")
        ?: throw IllegalStateException("Push key not set")
    val cachePassword = System.getenv("CACHE_PASSWORD")
        ?: throw IllegalStateException("Cache password not set")

    val services = ApplicationServices(
        dbHost = "db.prod.example.com",
        dbPort = 5432,
        dbName = "main_app_db",
        dbUser = "app_user",
        dbPassword = dbPassword,
        serviceToken = serviceToken,
        sendGridKey = sendGridKey,
        stripeKey = stripeKey,
        githubToken = githubToken,
        weatherApiKey = weatherApiKey,
        awsAccessKey = awsAccessKey,
        awsSecretKey = awsSecretKey
    )

    val utils = AppUtils(
        analyticsToken = analyticsToken,
        pushKey = pushKey,
        cachePassword = cachePassword
    )

    services.performCriticalTask()

    val isValid = services.validateAdmin("admin", "correct_password")
    println("Admin login: $isValid")
}
