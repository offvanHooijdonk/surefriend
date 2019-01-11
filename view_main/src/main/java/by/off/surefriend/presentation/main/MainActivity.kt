package by.off.surefriend.presentation.main

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import by.off.surefriend.presentation.clients.ClientsFragment
import by.off.surefriend.presentation.di.MainComponent
import by.off.surefriend.presenter.InsuranceFragment
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

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        navigate(Navigation.default())
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

    private fun navigate(nav: Navigation) {
        val fr: Fragment? =
            when (nav) {
                Navigation.CLIENTS -> {
                    ClientsFragment()
                }
                Navigation.OFFERS -> {
                    InsuranceFragment()
                }
                Navigation.WHAT -> {
                    toast("Sorry but no."); null
                }
            }

        if (fr != null) {
            supportFragmentManager.beginTransaction().replace(container.id, fr).commit()
        }
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_clients -> {
                navigate(Navigation.CLIENTS)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_offers -> {
                navigate(Navigation.OFFERS)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_something -> {
                navigate(Navigation.WHAT)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
}

private enum class Navigation {
    CLIENTS, OFFERS, WHAT;

    companion object {
        fun default() = CLIENTS
    }
}