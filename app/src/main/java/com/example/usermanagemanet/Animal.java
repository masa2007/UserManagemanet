package com.example.usermanagemanet;

public class Animal {
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
        }

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

    }

