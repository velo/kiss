package com.marvinformatics.kiss.matchers.httpstatus;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThan;

import org.hamcrest.Matcher;

/**
 * <p>HttpStatusMatchers class.</p>
 *
 * @author Marvin
 * @since 0.7
 */
public final class HttpStatusMatchers
{

    static
    {
        // quick dirty way to add code coverage to the constructor
        new HttpStatusMatchers();
    }

    private HttpStatusMatchers()
    {
        super();
    }

    /**
     * Status code (100) indicating the client can continue.
     */
    public static Matcher<? super Integer> continueStatus()
    {
        return equalTo( 100 );
    }

    /**
     * Status code (101) indicating the server is switching protocols according to Upgrade header.
     */
    public static Matcher<? super Integer> switchingProtocols()
    {
        return equalTo( 101 );
    }

    /**
     * Status code (200) indicating the request succeeded normally.
     */
    public static Matcher<? super Integer> ok()
    {
        return equalTo( 200 );
    }

    /**
     * Status code (201) indicating the request succeeded and created a new resource on the server.
     */
    public static Matcher<? super Integer> created()
    {
        return equalTo( 201 );
    }

    /**
     * Status code (202) indicating that a request was accepted for processing, but was not completed.
     */
    public static Matcher<? super Integer> accepted()
    {
        return equalTo( 202 );
    }

    /**
     * Status code (203) indicating that the meta information presented by the client did not originate from the server.
     */
    public static Matcher<? super Integer> nonAuthoritativeInformation()
    {
        return equalTo( 203 );
    }

    /**
     * Status code (204) indicating that the request succeeded but that there was no new information to return.
     */
    public static Matcher<? super Integer> noContent()
    {
        return equalTo( 204 );
    }

    /**
     * Status code (205) indicating that the agent <em>SHOULD</em> reset the document view which caused the request to
     * be sent.
     */
    public static Matcher<? super Integer> resetContent()
    {
        return equalTo( 205 );
    }

    /**
     * Status code (206) indicating that the server has fulfilled the partial GET request for the resource.
     */
    public static Matcher<? super Integer> partialContent()
    {
        return equalTo( 206 );
    }

    /**
     * Status code (300) indicating that the requested resource corresponds to any one of a set of representations, each
     * with its own specific location.
     */
    public static Matcher<? super Integer> multipleChoices()
    {
        return equalTo( 300 );
    }

    /**
     * Status code (301) indicating that the resource has permanently moved to a new location, and that future
     * references should use a new URI with their requests.
     */
    public static Matcher<? super Integer> movedPermanently()
    {
        return equalTo( 301 );
    }

    /**
     * Status code (302) indicating that the resource has temporarily moved to another location, but that future
     * references should still use the original URI to access the resource.
     * <p/>
     * This definition is being retained for backwards compatibility. SC_FOUND is now the preferred definition.
     */
    public static Matcher<? super Integer> movedTemporarily()
    {
        return equalTo( 302 );
    }

    /**
     * Status code (302) indicating that the resource reside temporarily under a different URI. Since the redirection
     * might be altered on occasion, the client should continue to use the Request-URI for future requests.(HTTP/1.1) To
     * represent the status code (302), it is recommended to use this variable.
     */
    public static Matcher<? super Integer> found()
    {
        return equalTo( 302 );
    }

    /**
     * Status code (303) indicating that the response to the request can be found under a different URI.
     */
    public static Matcher<? super Integer> seeOther()
    {
        return equalTo( 303 );
    }

    /**
     * Status code (304) indicating that a conditional GET operation found that the resource was available and not
     * modified.
     */
    public static Matcher<? super Integer> notModified()
    {
        return equalTo( 304 );
    }

    /**
     * Status code (305) indicating that the requested resource <em>MUST</em> be accessed through the proxy given by the
     * <code><em>Location</em></code> field.
     */
    public static Matcher<? super Integer> useProxy()
    {
        return equalTo( 305 );
    }

    /**
     * Status code (307) indicating that the requested resource resides temporarily under a different URI. The temporary
     * URI <em>SHOULD</em> be given by the <code><em>Location</em></code> field in the response.
     */
    public static Matcher<? super Integer> temporaryRedirect()
    {
        return equalTo( 307 );
    }

    /**
     * Status code (400) indicating the request sent by the client was syntactically incorrect.
     */
    public static Matcher<? super Integer> badRequest()
    {
        return equalTo( 400 );
    }

    /**
     * Status code (401) indicating that the request requires HTTP authentication.
     */
    public static Matcher<? super Integer> unauthorized()
    {
        return equalTo( 401 );
    }

    /**
     * Status code (402) reserved for future use.
     */
    public static Matcher<? super Integer> paymentRequired()
    {
        return equalTo( 402 );
    }

    /**
     * Status code (403) indicating the server understood the request but refused to fulfill it.
     */
    public static Matcher<? super Integer> forbidden()
    {
        return equalTo( 403 );
    }

    /**
     * Status code (404) indicating that the requested resource is not available.
     */
    public static Matcher<? super Integer> notFound()
    {
        return equalTo( 404 );
    }

    /**
     * Status code (405) indicating that the method specified in the <code><em>Request-Line</em></code> is not allowed
     * for the resource identified by the <code><em>Request-URI</em></code>.
     */
    public static Matcher<? super Integer> methodNotAllowed()
    {
        return equalTo( 405 );
    }

    /**
     * Status code (406) indicating that the resource identified by the request is only capable of generating response
     * entities which have content characteristics not acceptable according to the accept headers sent in the request.
     */
    public static Matcher<? super Integer> notAcceptable()
    {
        return equalTo( 406 );
    }

    /**
     * Status code (407) indicating that the client <em>MUST</em> first authenticate itself with the proxy.
     */
    public static Matcher<? super Integer> proxyAuthenticationRequired()
    {
        return equalTo( 407 );
    }

    /**
     * Status code (408) indicating that the client did not produce a request within the time that the server was
     * prepared to wait.
     */
    public static Matcher<? super Integer> requestTimeout()
    {
        return equalTo( 408 );
    }

    /**
     * Status code (409) indicating that the request could not be completed due to a conflict with the current state of
     * the resource.
     */
    public static Matcher<? super Integer> conflict()
    {
        return equalTo( 409 );
    }

    /**
     * Status code (410) indicating that the resource is no longer available at the server and no forwarding address is
     * known. This condition <em>SHOULD</em> be considered permanent.
     */
    public static Matcher<? super Integer> gone()
    {
        return equalTo( 410 );
    }

    /**
     * Status code (411) indicating that the request cannot be handled without a defined
     * <code><em>Content-Length</em></code>.
     */
    public static Matcher<? super Integer> lengthRequired()
    {
        return equalTo( 411 );
    }

    /**
     * Status code (412) indicating that the precondition given in one or more of the request-header fields evaluated to
     * false when it was tested on the server.
     */
    public static Matcher<? super Integer> preconditionFailed()
    {
        return equalTo( 412 );
    }

    /**
     * Status code (413) indicating that the server is refusing to process the request because the request entity is
     * larger than the server is willing or able to process.
     */
    public static Matcher<? super Integer> requestEntityTooLarge()
    {
        return equalTo( 413 );
    }

    /**
     * Status code (414) indicating that the server is refusing to service the request because the
     * <code><em>Request-URI</em></code> is longer than the server is willing to interpret.
     */
    public static Matcher<? super Integer> requestUriTooLong()
    {
        return equalTo( 414 );
    }

    /**
     * Status code (415) indicating that the server is refusing to service the request because the entity of the request
     * is in a format not supported by the requested resource for the requested method.
     */
    public static Matcher<? super Integer> unsupportedMediaType()
    {
        return equalTo( 415 );
    }

    /**
     * Status code (416) indicating that the server cannot serve the requested byte range.
     */
    public static Matcher<? super Integer> requestedRangeNotSatisfiable()
    {
        return equalTo( 416 );
    }

    /**
     * Status code (417) indicating that the server could not meet the expectation given in the Expect request header.
     */
    public static Matcher<? super Integer> expectationFailed()
    {
        return equalTo( 417 );
    }

    /**
     * Status code (500) indicating an error inside the HTTP server which prevented it from fulfilling the request.
     */
    public static Matcher<? super Integer> internalServerError()
    {
        return equalTo( 500 );
    }

    /**
     * Status code (501) indicating the HTTP server does not support the functionality needed to fulfill the request.
     */
    public static Matcher<? super Integer> notImplemented()
    {
        return equalTo( 501 );
    }

    /**
     * Status code (502) indicating that the HTTP server received an invalid response from a server it consulted when
     * acting as a proxy or gateway.
     */
    public static Matcher<? super Integer> badGateway()
    {
        return equalTo( 502 );
    }

    /**
     * Status code (503) indicating that the HTTP server is temporarily overloaded, and unable to handle the request.
     */
    public static Matcher<? super Integer> serviceUnavailable()
    {
        return equalTo( 503 );
    }

    /**
     * Status code (504) indicating that the server did not receive a timely response from the upstream server while
     * acting as a gateway or proxy.
     */
    public static Matcher<? super Integer> gatewayTimeout()
    {
        return equalTo( 504 );
    }

    /**
     * Status code (505) indicating that the server does not support or refuses to support the HTTP protocol version
     * that was used in the request message.
     */
    public static Matcher<? super Integer> httpVersionNotSupported()
    {
        return equalTo( 505 );
    }

    /**
     * Any 20x status
     */
    public static Matcher<? super Integer> success()
    {
        return allOf( greaterThanOrEqualTo( 200 ), lessThan( 300 ) );
    }

    /**
     * Any 30x status
     */
    public static Matcher<? super Integer> redirect()
    {
        return allOf( greaterThanOrEqualTo( 300 ), lessThan( 400 ) );
    }

    /**
     * Any 40x status
     */
    public static Matcher<? super Integer> clientError()
    {
        return allOf( greaterThanOrEqualTo( 400 ), lessThan( 500 ) );
    }

    /**
     * Any 50x status
     */
    public static Matcher<? super Integer> serverError()
    {
        return allOf( greaterThanOrEqualTo( 500 ), lessThan( 600 ) );
    }
}
