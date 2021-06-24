package acosta.michael.practica6_popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


class MovieDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val bundle = intent.extras
        var ns = 0;
        var id = -1;
        var title = "";

        var mHeader: ImageView = findViewById(R.id.movie_header)
        var mTitle: TextView = findViewById(R.id.movie_title_detail)
        var mDetail: TextView = findViewById(R.id.movie_summary)
        var seats: TextView = findViewById(R.id.seatsLeft)
        var bt: Button = findViewById(R.id.buyTickets)


        if (bundle != null){

            ns = bundle.getInt("numberSeats")
            title = bundle.getString("titulo")!!
            mHeader.setImageResource(bundle.getInt("header"))
            mTitle.setText(bundle.getString("titulo"))
            mDetail.setText(bundle.getString("sinopsis"))
            seats.setText("$ns seats available ")
            id = bundle.getInt("pos")

        }

        if (ns == 0) {
            bt.isEnabled = false
        } else {
            bt.setOnClickListener {
                val intent: Intent = Intent(this, SeatSelection::class.java)

                intent.putExtra("id", id)
                intent.putExtra("name", title)

                this.startActivity(intent)

            }
        }

    }
}