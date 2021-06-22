package acosta.michael.practica6_popcornfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView


class MovieDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val bundle = intent.extras

        if (bundle != null){

            var mHeader: ImageView = findViewById(R.id.movie_header)
            var mTitle: TextView = findViewById(R.id.movie_title_detail)
            var mDetail: TextView = findViewById(R.id.movie_summary)

            mHeader.setImageResource(bundle.getInt("header"))
            mTitle.setText(bundle.getString("titulo"))
            mDetail.setText(bundle.getString("sinopsis"))
        }

    }
}