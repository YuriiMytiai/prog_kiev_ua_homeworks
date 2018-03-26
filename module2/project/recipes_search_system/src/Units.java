public enum Units {
    PIECES {
        @Override
        public String toString() {
            return "p";
        }
    },
    KILOGRAMS {
        @Override
        public String toString() {
            return "kg";
        }
    },
    GRAMS {
        @Override
        public String toString() {
            return "g";
        }
    },
    LITERS {
        @Override
        public String toString() {
            return "l";
        }
    },
    MILLILITERS {
        @Override
        public String toString() {
            return "ml";
        }
    }

}
