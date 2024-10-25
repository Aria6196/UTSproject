package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val foodName = intent.getStringExtra("foodName") ?: "Unknown"
        val tvSelectedFood: TextView = findViewById(R.id.tvSelectedFood)
        tvSelectedFood.text = foodName

        val etServings: EditText = findViewById(R.id.etServings)
        val etName: EditText = findViewById(R.id.etName)
        val etNotes: EditText = findViewById(R.id.etNotes)
        val btnOrder: Button = findViewById(R.id.btnOrder)

        btnOrder.setOnClickListener {
            val servings = etServings.text.toString()
            val name = etName.text.toString()
            val notes = etNotes.text.toString()

            // Create intent to start ConfirmationActivity
            val intent = Intent(this, ConfirmationActivity::class.java)
            intent.putExtra("foodName", foodName)
            intent.putExtra("servings", servings)
            intent.putExtra("name", name)
            intent.putExtra("notes", notes)

            // Start ConfirmationActivity
            startActivity(intent)
        }
    }
}
