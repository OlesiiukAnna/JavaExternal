package ua.flatware.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.flatware.annotations.Fork;
import ua.flatware.annotations.Knife;
import ua.flatware.annotations.Spoon;
import ua.flatware.data.entity.*;
import ua.flatware.exceptions.LengthNotValidException;
import ua.flatware.exceptions.QuantityNotValidException;
import ua.flatware.exceptions.VolumeNotValidException;
import ua.flatware.exceptions.WithNotValidException;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static ua.flatware.data.FlatwareTypes.*;

public class FlatwareValidator {

    private final static Logger logger = LoggerFactory.getLogger(FlatwareValidator.class);
    private static FlatwareValidator flatwareValidator = new FlatwareValidator();

    private FlatwareValidator() {

    }

    public static FlatwareValidator getFlatwareValidator() {
        return flatwareValidator;
    }

    public static boolean isFlatwareValid(Flatware flatware) {
        List<Ware> wares = flatware.getFlatware();

        List<Boolean> flatwareValid = new ArrayList<>();

        try {
            for (Ware ware : wares) {
                if (ware.getType().equals(KNIFE.getType())) {
                    flatwareValid.add(validateKnife(ware));
                } else if (ware.getType().equals(FORK.getType())) {
                    flatwareValid.add(validateFork(ware));
                } else if (ware.getType().equals(SPOON.getType())) {
                    flatwareValid.add(validateSpoon(ware));
                }
            }
        } catch (QuantityNotValidException | LengthNotValidException |
                IllegalAccessException | WithNotValidException |
                VolumeNotValidException e) {
            logger.error("Flatware validation error", e);
        }

        return !flatwareValid.contains(false);
    }

    private static boolean validateKnife(Ware ware) throws IllegalAccessException, LengthNotValidException, WithNotValidException {
        boolean lengthIsValid = false;
        boolean widthIsValid = false;
        Blade blade = ware.getVisual().getActivePart().getBlade();
        Class<Blade> bladeClass = Blade.class;
        Field[] fields = bladeClass.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Knife.class)) {
                int getField = field.getInt(blade);
                Knife initAn = field.getAnnotation(Knife.class);

                if (field.getName().equals("length")) {
                    int minAllowedLength = initAn.scoopMinLength();
                    int maxAllowedLength = initAn.scoopMaxLength();
                    if (minAllowedLength <= getField && getField <= maxAllowedLength) {
                        lengthIsValid = true;
                    } else {
                        logger.error("Length not valid", new LengthNotValidException());
                    }
                }

                if (field.getName().equals("width")) {
                    int minAllowedWidth = initAn.bladeMinWidth();
                    int maxAllowedWidth = initAn.bladeMaxWidth();
                    if (minAllowedWidth <= getField && getField <= maxAllowedWidth) {
                        widthIsValid = true;
                    } else {
                        logger.error("Width not valid", new WithNotValidException());
                    }
                }

            }
        }
        return lengthIsValid && widthIsValid;
    }

    private static boolean validateFork(Ware ware) throws IllegalAccessException, QuantityNotValidException, LengthNotValidException {
        boolean lengthIsValid = false;
        boolean quantityIsValid = false;

        Prong prong = ware.getVisual().getActivePart().getProng();

        Class<Prong> forkClass = Prong.class;
        Field[] fields = forkClass.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Fork.class)) {
                int getField = field.getInt(prong);
                Fork initAn = field.getAnnotation(Fork.class);

                if (field.getName().equals("length")) {
                    int minAllowedLength = initAn.prongMinLength();
                    int maxAllowedLength = initAn.prongMaxLength();
                    if (minAllowedLength <= getField && getField <= maxAllowedLength) {
                        lengthIsValid = true;
                    } else {
                        logger.error("Length not valid", new LengthNotValidException());
                    }
                }


                if (field.getName().equals("quantity")) {
                    int minAllowedQuantity = initAn.prongMinQuantity();
                    int maxAllowedQuantity = initAn.prongMaxQuantity();
                    if (minAllowedQuantity <= getField && getField <= maxAllowedQuantity) {
                        quantityIsValid = true;
                    } else {
                        logger.error("Quantity not valid", new QuantityNotValidException());
                    }
                }
            }
        }
        return lengthIsValid && quantityIsValid;
    }

    private static boolean validateSpoon(Ware ware) throws IllegalAccessException, VolumeNotValidException {
        boolean volumeIsValid = false;
        Scoop scoop = ware.getVisual().getActivePart().getScoop();
        Class<Scoop> scoopClass = Scoop.class;
        Field[] fields = scoopClass.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Spoon.class)) {
                int getField = field.getInt(scoop);
                Spoon initAn = field.getAnnotation(Spoon.class);

                if (field.getName().equals("volume")) {
                    int minAllowedVolume = initAn.scoopMinVolume();
                    int maxAllowedVolume = initAn.scoopMaxVolume();
                    if (minAllowedVolume <= getField && getField <= maxAllowedVolume) {
                        volumeIsValid = true;
                    } else {
                        logger.error("Volume not valid", new VolumeNotValidException());
                    }
                }
            }
        }
        return volumeIsValid;
    }
}
