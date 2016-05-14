package ga.rugal.food.core.entity;

import com.google.gson.Gson;

/**
 *
 * @author Rugal Bernstein
 * @param <T>
 */
public abstract class BaseObject<T>
{

    private static final Gson GSON = new Gson();

    public T backToObject(Object data)
    {
        return this.backToObject(GSON.toJson(data));
    }

    public T backToObject(String json)
    {
        return GSON.fromJson(json, this.getRealClass());
    }

    protected abstract Class<T> getRealClass();

}
