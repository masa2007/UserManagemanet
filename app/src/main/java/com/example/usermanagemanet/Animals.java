package com.example.usermanagemanet;

    public class Animals {
        private String type;
        private String gender;
        private  String age;
        private String BirthOfDate;
        private  String color;
        private  String place;
        private  int price;

        public Animals(String type, String gender, String age, String birthdate, String color, String place, String category, String price) {
        }

        public Animals(String type, String gender, String age, String birthOfDate, String color, String place) {
            this.type = type;
            this.gender = gender;
            this.age = age;
            BirthOfDate = birthOfDate;
            this.color = color;
            this.place = place;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Animals{" +
                    "type='" + type + '\'' +
                    ", gender='" + gender + '\'' +
                    ", age='" + age + '\'' +
                    ", BirthOfDate='" + BirthOfDate + '\'' +
                    ", color='" + color + '\'' +
                    ", place='" + place + '\'' +
                    ", price='" + price+ '\'' +
                    '}';
        }

        public String getPlace() {
            return place;
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

        public void setBirthOfDate(String birthOfDate) {
            BirthOfDate = birthOfDate;
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

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setPrice(int price) {
            this.price = price;
        }

    }

