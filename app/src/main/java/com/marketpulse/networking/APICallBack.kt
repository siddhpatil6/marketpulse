
import android.app.Activity
import com.marketpulse.networking.APIInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



open class APICallback<T>(apiInterface: APIInterface<T>, activity: Activity?) : Callback<T> {

    var apiInterface = apiInterface

    var activity = activity

    init {

    }

    override fun onResponse(call: Call<T>, response: Response<T>) {
        if (response != null && response.isSuccessful && response.errorBody() == null) {

            apiInterface.onResponse(response = response.body()!!)


        } else {

            if (response.code() == 500) {
            } else {

            }
            if (apiInterface != null) {
                apiInterface.onError()
            }

        }

    }

    override fun onFailure(call: Call<T>, t: Throwable) {


        if (apiInterface != null) {
            apiInterface.onError()
        }
    }
}