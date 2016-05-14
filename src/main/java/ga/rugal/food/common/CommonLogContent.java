package ga.rugal.food.common;

/**
 *
 * @author rugal
 */
public interface CommonLogContent
{

    //static resources
    final String IMAGE_NOT_FOUND = "Image [%s] not found";

    final String ERROR_READ_IMAGE = "Exception occurs while reading %s";

    final String IMAGE_LENGTH = "Length of byte array is %s";

    //menu
    final String NO_MENU = "No matched menu found";

    final String MENU_NUMBER = "Count %d menu entry in database";

    final String GET_FROM_ALL = "Start to get random menu from all";

    final String GET_MENU_BY_MEAL = "Start to get random menu by meal type";

    //Restaurant
    final String RESTAURANT_NUMBER = "Count {} entry in database";

    final String NO_RESTAURANT = "Restaurant data is empty";

    final String RESAURANT_NOT_FOUND = "There is no restaurant in database";

    final String GET_RESTAURANT = "Get restaurant with rid [{}]";

    final String COUNT_RESTAURANT = "With total restaurant [{}]";

    //meal type
    final String INVALID_MEAL_TYPE = "Invalid meal type [{}]";

}
