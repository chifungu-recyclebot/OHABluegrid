package ui.admin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.greenway.ohabluegrid.databinding.FragmentAdminTableBinding

class AdminTableFragment : Fragment() {

    private lateinit var binding: FragmentAdminTableBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAdminTableBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Access views using the binding object
        binding.textViewTitle.text = "Admin Table" // Example TextView

        // Example RecyclerView setup
        binding.recyclerViewAdmin.layoutManager = LinearLayoutManager(requireContext())

        // Example Button click listener
        binding.buttonSubmit.setOnClickListener {
            // Handle button click
        }
    }

    companion object {
        fun newInstance(): AdminTableFragment {
            return AdminTableFragment()
        }
    }
}
