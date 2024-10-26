package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ConfirmationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)

        val backtoMenu = findViewById<Button>(R.id.backtoMenu)

        val tvSelectedFood: TextView = findViewById(R.id.tvSelectedFood)
        val tvServings: TextView = findViewById(R.id.tvServings)
        val tvName: TextView = findViewById(R.id.tvName)
        val tvNotes: TextView = findViewById(R.id.tvNotes)

        val foodName = intent.getStringExtra("foodName")
        val servings = intent.getStringExtra("servings")
        val name = intent.getStringExtra("name")
        val notes = intent.getStringExtra("notes")

        tvSelectedFood.text = foodName
        tvServings.text = "Servings: $servings"
        tvName.text = "Name: $name"
        tvNotes.text = "Notes: $notes"

        backtoMenu.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, ListFoodActivity::class.java)
            startActivity(intent)
        })
    }
}
