 package com.example.myapplication

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView

 class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

     var adapter: MyAdapter? = null

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nav_view = findViewById<NavigationView>(R.id.nav_view)
        nav_view.setNavigationItemSelectedListener (this)

        var list = ArrayList<ListItem>()

        var rcView = findViewById<RecyclerView>(R.id.rcView)  //решение проблемы. Поскольку сейчас нужно искать элементы снова через findViewById

         list.addAll(fillArrays(
             resources.getStringArray(R.array.fish),
             resources.getStringArray(R.array.fish_content),
             getImageId(R.array.fish_image_array)))
        rcView.hasFixedSize()
        rcView.layoutManager = LinearLayoutManager(this)
         adapter = MyAdapter(list,this)
        rcView.adapter = adapter


    }

 //    fun toastMe (view: View){
  //      Toast.makeText(this, "Товар успешно добавлен в корзину", Toast.LENGTH_SHORT).show()
 //   }

     override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId)  { //возваращет идентификатор который мы нажали

            R.id.id_fish -> {
                Toast.makeText(this, "Id fish", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.fish),
                    resources.getStringArray(R.array.fish_content), getImageId(R.array.fish_image_array)))
            }
            R.id.id_na ->  {
                Toast.makeText(this, "Id na", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.na),
                    resources.getStringArray(R.array.na_content), getImageId(R.array.na_image_array)))
            }

            R.id.id_sna ->  {
                Toast.makeText(this, "Id sna", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.sna),
                    resources.getStringArray(R.array.sna_content), getImageId(R.array.sna_image_array)))
            }

            R.id.id_history ->
            {
                Toast.makeText(this, "Id history", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.history),
                    resources.getStringArray(R.array.history_content), getImageId(R.array.history_image_array)))
            }

            R.id.id_Onas ->
            {
                Toast.makeText(this, "Id Onas", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.Onas),
                    resources.getStringArray(R.array.Onas_content), getImageId(R.array.Onas_image_array)))
            }

        }

         var drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
         drawerLayout.closeDrawer(GravityCompat.START)
         return true
     }

     fun fillArrays(titleArray: Array<String>, contentArray: Array<String>, imageArray: IntArray ):List<ListItem>
     {
        var listItemArray = ArrayList<ListItem>()
         for (n in 0..titleArray.size - 1 )
         {
             var listItem = ListItem(imageArray[n],titleArray[n],contentArray[n] )
             listItemArray.add(listItem)
         }
         return listItemArray
     }

    fun getImageId(imageArrayId:Int): IntArray
    {
        var tArray:TypedArray = resources.obtainTypedArray(imageArrayId)
        val count = tArray.length()
        val ids = IntArray(count)
        for (i in ids.indices)
        {
            ids[i] = tArray.getResourceId(i,0)
        }
        tArray.recycle()
        return ids
    }



 }