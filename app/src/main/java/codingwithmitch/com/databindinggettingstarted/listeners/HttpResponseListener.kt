package codingwithmitch.com.databindinggettingstarted.listeners

/**
 * Created by Banty on 16/09/18.
 */
interface HttpResponseListener {
    fun responseReceived(response: String?)
}