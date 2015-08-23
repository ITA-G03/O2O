package ita.o2o.entity.base;

import ita.o2o.entity.extra.Status;
import ita.o2o.entity.extra.Tag;
import ita.o2o.entity.location.Location;

import java.util.Set;

/**
 * @author Aquariuslt
 * @version 15-08-22
 */
public class Business {
    private int businessId;
    private String realName;
    private Status status;
    private User owner;
    private Set<Tag> tags;
    private Location location;
    private int idCardId;
    private int licenseId;
    private int logoId;



}
