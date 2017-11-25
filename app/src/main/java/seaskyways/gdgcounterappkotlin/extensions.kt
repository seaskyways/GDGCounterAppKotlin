package seaskyways.gdgcounterappkotlin

import android.support.v7.app.AppCompatActivity
import android.widget.Toast

/** Created by seaskyways on 11/25/17. */

fun AppCompatActivity.showToast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, length).show()
}