package seaskyways.gdgcounterappkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    
    private val messageStore = mutableMapOf<Int, String>()
    
    private var currentCount by Delegates.observable(0) { _, _, new ->
        txtCount.text = new.toString()
        checkMessages(new)
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        btnCount.setOnClickListener { view ->
            currentCount++
        }
        
        btnSave.setOnClickListener {
            val count = inputNumber.text.toString().toIntOrNull()
            val message = inputMessage.text.toString().trim()
            
            if (count == null) {
                showToast("Please enter a valid count")
                return@setOnClickListener
            }
            
            if (message.isBlank()) {
                showToast("Please enter a valid Message")
                return@setOnClickListener
            }
            
            messageStore[count] = message
        }
    }
    
    fun checkMessages(count: Int) {
        if (messageStore.containsKey(count)) {
            Toast.makeText(this, messageStore[count], Toast.LENGTH_LONG).show()
        }
    }
}
