package ga.rugal.food.core.service;

import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rugal Bernstein
 */
public interface StaticResourceService
{

    Object getImage(String filename, HttpServletResponse response);

}
