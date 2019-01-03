package com.ashish;

public class Book {
    private String bookName;
    private String bookUniqueNumber;
    private float bookPrice;
    private String bookGenre;

    private Book(BookBuilder bookBuilder) {
        this.bookName = bookBuilder.bookName;
        this.bookUniqueNumber = bookBuilder.bookUniqueNumber;
        this.bookPrice = bookBuilder.bookPrice;
        this.bookGenre = bookBuilder.bookGenre;
    }

    public static class BookBuilder {

        private String bookName;
        private String bookUniqueNumber;
        private float bookPrice;
        private String bookGenre;

        public BookBuilder(String bookUniqueNumber) {
            this.bookUniqueNumber = bookUniqueNumber;
        }

        public BookBuilder setBookName(String bookName) {
            this.bookName = bookName;
            return this;
        }

        public BookBuilder setBookPrice(float bookPrice) {
            this.bookPrice = bookPrice;
            return this;
        }

        public BookBuilder setBookGenre(String bookGenre) {
            this.bookGenre = bookGenre;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }

    public enum BookGenre {
        FICTION(1), COMEDY(2), FANTASY(3), EROTIC(4), SCIENCE(5), TECHNOLOGY(6), ART(7), MISCELLANEOUS(8);

        private int genreNumber;

        BookGenre(int genreNumber) {
            this.genreNumber = genreNumber;
        }

        public int getGenreNumber() {
            return genreNumber;
        }
    }
}
