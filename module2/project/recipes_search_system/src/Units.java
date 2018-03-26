public enum Units {
    Pieces {
        @Override
        public String toString() {
            return "p";
        }
    },
    Kilograms {
        @Override
        public String toString() {
            return "kg";
        }
    },
    Grams {
        @Override
        public String toString() {
            return "g";
        }
    },
    Liters {
        @Override
        public String toString() {
            return "l";
        }
    },
    Milliliters {
        @Override
        public String toString() {
            return "ml";
        }
    }

}
