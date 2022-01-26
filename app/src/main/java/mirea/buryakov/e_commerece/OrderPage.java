package mirea.buryakov.e_commerece;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import mirea.buryakov.e_commerece.model.Course;
import mirea.buryakov.e_commerece.model.Order;

public class OrderPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);

        ListView orders_list = findViewById(R.id.orders_list);

        List<String> coursesTitle = new ArrayList<>();
        for (Course c : MainActivity.fullCourseList) {
            if(Order.itemsId.contains(c.getId())) {
                coursesTitle.add(c.getTitle());
            }
        }

        orders_list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, coursesTitle));

    }
}