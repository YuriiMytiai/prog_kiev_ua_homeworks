import java.io.Serializable;
import java.util.HashMap;

public enum DishCategory implements Serializable {
    // according to Wikipedia: https://en.wikipedia.org/wiki/Category:Lists_of_foods_by_type
    // there should be much more fields in production release
    BACON_SUBSTITUTES,
    BARBEQUE,
    BREAD,
    CAKES,
    CASSEROLES,
    SALADS,
    SAUCES,
    SOUPS,
    DRINKS,
    OTHER;
}
