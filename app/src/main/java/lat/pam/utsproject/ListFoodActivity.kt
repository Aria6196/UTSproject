package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFoodActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FoodAdapter
    private lateinit var foodList: List<Food>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_food)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Create food list
        foodList = listOf(
            Food("Batagor", "Batagor asli enak dari Bandung", R.drawable.batagor),
            Food("Black Salad", "Salad segar yang dibuat langsung", R.drawable.black_salad),
            Food("Cappuccino", "Kopi cappuccino dari Arabica", R.drawable.cappuchino)
        )

        adapter = FoodAdapter(foodList) { selectedFood ->
            // Pass selected food to OrderActivity
            val intent = Intent(this, OrderActivity::class.java)
            intent.putExtra("foodName", selectedFood.name)
            startActivity(intent)
        }

        recyclerView.adapter = adapter

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
