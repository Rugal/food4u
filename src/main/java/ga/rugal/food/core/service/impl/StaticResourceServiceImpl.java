package ga.rugal.food.core.service.impl;

import ga.rugal.food.core.service.StaticResourceService;
import config.SystemDefaultProperties;
import ga.rugal.food.common.CommonLogContent;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

/**
 *
 * @author Rugal Bernstein
 */
@Service
public class StaticResourceServiceImpl implements StaticResourceService
{

    @Autowired
    private ServletContext context;

    private static final Logger LOG = LoggerFactory.getLogger(StaticResourceServiceImpl.class.getName());

    private static final File IMAGE_FOLDER = new File(SystemDefaultProperties.IMAGE_FOLDER);

    @Override
    public Object getImage(String filename, HttpServletResponse response)
    {
        byte[] data;
        File image = new File(IMAGE_FOLDER, SystemDefaultProperties.DEFAULT_IMAGE);
        try
        {
            image = new File(IMAGE_FOLDER, filename);
            //prevent from loading non-exists image
            if (!image.exists())
            {
                //if no image file found in path
                LOG.info(String.format(CommonLogContent.IMAGE_NOT_FOUND, image.getName()));
                return null;
            }
            LOG.trace(image.getPath());
            data = FileCopyUtils.copyToByteArray(image);
        }
        catch (IOException ex)
        {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            LOG.error(String.format(CommonLogContent.ERROR_READ_IMAGE, image.getName()), ex);
            return null;
        }
        LOG.trace(String.format(CommonLogContent.IMAGE_LENGTH, data.length));
        response.setContentType(context.getMimeType(image.getName()));
        response.setContentLength(data.length);
        response.setStatus(HttpServletResponse.SC_OK);
        return data;
    }
}
