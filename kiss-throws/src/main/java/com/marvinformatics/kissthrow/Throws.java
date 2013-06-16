package com.marvinformatics.kissthrow;

/**
 * Utility class to silently throw exceptions as they were runtime exceptions, but they still being the original
 * exception type
 *
 * @author marvin.froeder
 * @since 0.7
 */
public final class Throws
{

    static
    {
        // quick dirty way to add code coverage to the constructor
        new Throws();
    }

    private Throws()
    {
        super();
    }

    /**
     * Throws the original exception but eating the need for checked exceptions
     *
     * @param throwableElement an exception to be throw silently
     * @return nothing
     * @throws the original {@code throwableElement}
     */
    public static RuntimeException silentThrow( Throwable throwableElement )
        throws Throwable
    {
        throw throwableElement;
    }

}
