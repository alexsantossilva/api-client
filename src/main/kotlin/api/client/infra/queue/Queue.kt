package api.client.infra.queue

interface Queue {

    fun sendMessage(message: String)
}