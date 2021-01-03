package com.jadovan.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.jadovan.shoestore.databinding.ActivityMainBinding
import com.jadovan.shoestore.databinding.ShoeListFragmentBinding
import com.jadovan.shoestore.models.login.LoginFragmentDirections
import com.jadovan.shoestore.models.shoe_list.ShoeListFragmentDirections

class MainActivity : AppCompatActivity() {

    private val navController: NavController by lazy { findNavController(R.id.nav_host_fragment) }

    private lateinit var appBarConfiguration: AppBarConfiguration

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        ).apply {
            viewBinding = this
            setSupportActionBar(this.toolbar)
            appBarConfiguration = AppBarConfiguration(navController.graph)
            setupActionBarWithNavController(
                navController,
                appBarConfiguration
            )
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }

    override fun onBackPressed() {}

}
