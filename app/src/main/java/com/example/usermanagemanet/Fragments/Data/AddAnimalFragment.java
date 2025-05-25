package com.example.usermanagemanet.Fragments.Data;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.usermanagemanet.Fragments.Classes.Animal;
import com.example.usermanagemanet.Fragments.fragment.FireBaseServices;
import com.example.usermanagemanet.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;

public class AddAnimalFragment extends Fragment {

    private EditText etType, etGender, etAge, etColorAn, etPlaceAn, etPrice;
    private Button btnAdd;
    private FireBaseServices fbs;

    // ✅ تم تعطيل عرض الصورة واختيارها
    // private ImageView img;
    // private Utils utils;
    // private ActivityResultLauncher<String> imagePickerLauncher;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_animal, container, false);

        fbs = FireBaseServices.getInstance();
        etType = view.findViewById(R.id.etTypeAn);
        etGender = view.findViewById(R.id.etGenderAn);
        etAge = view.findViewById(R.id.etAgeAn);
        etColorAn = view.findViewById(R.id.etColorAn);
        etPlaceAn = view.findViewById(R.id.etPlaceAn);
        etPrice = view.findViewById(R.id.etPrice);
        btnAdd = view.findViewById(R.id.btnAdd);

        // ✅ تم إلغاء تفعيل كود اختيار الصورة
        // img = view.findViewById(R.id.ivamlAddamlFragment);
        // img.setOnClickListener(v -> imagePickerLauncher.launch("image/*"));

        btnAdd.setEnabled(true);

        btnAdd.setOnClickListener(v -> {
            String type = etType.getText().toString().trim();
            String gender = etGender.getText().toString().trim();
            String age = etAge.getText().toString().trim();
            String color = etColorAn.getText().toString().trim();
            String place = etPlaceAn.getText().toString().trim();
            String price = etPrice.getText().toString().trim();

            if (type.isEmpty() || gender.isEmpty() || age.isEmpty() || color.isEmpty()
                    || place.isEmpty() || price.isEmpty()) {
                Toast.makeText(getActivity(), "يرجى تعبئة جميع الحقول", Toast.LENGTH_SHORT).show();
                return;
            }

            // ✅ تم تمرير رابط صورة فارغ لأنه غير مستخدم
            Animal aml = new Animal(type, gender, age, color, place, price, "", "");

            fbs.getFire().collection("animals").add(aml)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(getActivity(), "تمت إضافة الحيوان بنجاح!", Toast.LENGTH_SHORT).show();
                            gotoAllAnimalFragment();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.e("فشل إضافة الحيوان", e.getMessage());
                        }
                    });
        });

        return view;
    }

    private void gotoAllAnimalFragment() {
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.FrameLayoutFrame, new AllAnimalFragment());
        ft.commit();
    }
}
