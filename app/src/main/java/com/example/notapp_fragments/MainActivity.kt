package com.example.notapp_fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.Navigation

open class MainActivity : AppCompatActivity() {
    //private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val home_Fragment=Home_Fragment()
        //supportFragmentManager.beginTransaction().replace(R.id.fragment_container,home_Fragment).commit()
        //navController = Navigation.findNavController(this, R.id.mainFragment)
    }

}


//override fun onSupportNavigateUp(): Boolean {
//    return navController.navigateUp()
//}

//    fun passData(id: String) {
//        val bundle = Bundle()
//        bundle.putString("id", id)
//        val transaction = this.supportFragmentManager.beginTransaction()
//        val fragmentTwo = Update_Fragment()
//        fragmentTwo.arguments = bundle
//        transaction.replace(R.id.fragment_container, fragmentTwo)
//        transaction.addToBackStack(null)
//        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
//        transaction.commit()
//    }


//    <FrameLayout
//        android:layout_width="match_parent"
//        android:layout_height="match_parent"
//        android:id="@+id/fragment_container"
//      app:layout_constraintBottom_toBottomOf="parent"
//      app:layout_constraintTop_toTopOf="parent"
//        app:layout_constraintRight_toRightOf="parent"
//        app:layout_constraintLeft_toLeftOf="parent"
//
//
//        />.
//   <androidx.fragment.app.FragmentContainerView
//          android:id="@+id/fragmentContainerView"
//          android:name="androidx.navigation.fragment.NavHostFragment"
//         android:layout_width="match_parent"
//          android:layout_height="match_parent"
//            app:defaultNavHost="true"
//           app:layout_constraintBottom_toBottomOf="parent"
//           app:layout_constraintEnd_toEndOf="parent"
//         app:layout_constraintStart_toStartOf="parent"
//         app:layout_constraintTop_toTopOf="parent"
//           app:navGraph="@navigation/home" />


