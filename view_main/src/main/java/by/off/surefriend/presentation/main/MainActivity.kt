package by.off.surefriend.presentation.main

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import by.off.surefriend.presentation.di.MainComponent
import by.off.surefriend.storage.StorageService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.jetbrains.anko.toast
import javax.inject.Inject
import kotlin.coroutines.EmptyCoroutineContext

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var storageService: StorageService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MainComponent.get(applicationContext).inject(this)

        NavigationUI.setupWithNavController(navigation, NavHostFragment.findNavController(navContainer))
        navigation.selectedItemId = R.id.toClientsGraph
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.item_add_data -> {
                CoroutineScope(EmptyCoroutineContext).launch {
                    storageService.initTestData()
                }
            }
        }
        return true
    }
}