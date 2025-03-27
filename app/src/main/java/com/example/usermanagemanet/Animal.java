package com.example.usermanagemanet;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Animal  implements Parcelable {
        private String type;
        private String gender;
        private  String age;
        private String BirthOfDate;
        private  String color;
        private  String place;
        private  int price;
        private String photo;


    public Animal(String type, String gender, String age, String color, String place, String price) {
        }

        public Animal(String type, String gender, String age,  String color, String place, String price,String photo) {
            this.type = type;
            this.gender = gender;
            this.age = age;
            this.color = color;
            this.place = place;
            this.price = Integer.parseInt(price);
            this.photo=photo;
        }

    protected Animal(Parcel in) {
        type = in.readString();
        gender = in.readString();
        age = in.readString();
        BirthOfDate = in.readString();
        color = in.readString();
        place = in.readString();
        price = in.readInt();
        photo = in.readString();
    }

    public static final Creator<Animal> CREATOR = new Creator<Animal>() {
        @Override
        public Animal createFromParcel(Parcel in) {
            return new Animal(in);
        }

        @Override
        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };

    @Override
        public String toString() {
            return "Animals{" +
                    "type='" + type + '\'' +
                    ", gender='" + gender + '\'' +
                    ", age='" + age + '\'' +
                    ", color='" + color + '\'' +
                    ", place='" + place + '\'' +
                    ", price='" + price+ '\'' +
                    ", photo='" + photo+ '\'' +

                    '}';
        }

        public String getPlace() {
            return place;
        }

    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }

        public void setPlace(String place) {
            this.place = place;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getBirthOfDate() {
            return BirthOfDate;
        }



        public String getAge() {
            return age;
        }

        public int getprice() {
            return price;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getType() {
            return type;
        }



        public void setGender(String gender) {
            this.gender = gender;
        }


        public void setType(String type) {
            this.type = type;
        }

        public void setPrice(int price) {
            this.price = price;
        }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(type);
        dest.writeString(gender);
        dest.writeString(age);
        dest.writeString(BirthOfDate);
        dest.writeString(color);
        dest.writeString(place);
        dest.writeInt(price);
        dest.writeString(photo);
    }
    @Override
    public int describeContents() {
        return 0;
    }
}

