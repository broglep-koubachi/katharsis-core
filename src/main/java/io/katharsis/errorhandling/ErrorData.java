package io.katharsis.errorhandling;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public final class ErrorData {

    /**
     * A unique identifier for this particular occurrence of the problem.
     */
    private final String id;

    /**
     * A link that leads to further details about this particular occurrence of the problem.
     *
     * Wrapped in "links" object.
     */
    private final String aboutLink;

    /**
     * The HTTP status code applicable to this problem, expressed as a string value.
     */
    private final String status;

    /**
     * An application-specific error code, expressed as a string value.
     */
    private final String code;

    /**
     * A short, human-readable summary of the problem.
     * It SHOULD NOT change from occurrence to occurrence of the problem, except for purposes of localization.
     */
    private final String title;

    /**
     * A human-readable explanation specific to this occurrence of the problem.
     */
    private final String detail;

    /**
     * A JSON Pointer [RFC6901] to the associated entity in the request document
     * [e.g. "/data" for a primary data object, or "/data/attributes/title" for a specific attribute].
     *
     * Wrapped in "source" object.
     */
    private final String sourcePointer;

    /**
     * A string indicating which query parameter caused the error.
     *
     * Wrapped in "source" object.
     */
    private final String sourceParameter;

    /**
     * A meta object containing non-standard meta-information about the error.
     */
    private final Map<String, Object> meta;

    public ErrorData(String id, String aboutLink, String status, String code, String title, String detail,
                     String sourcePointer, String sourceParameter, Map<String,Object> meta) {
        this.id = id;
        this.aboutLink = aboutLink;
        this.status = status;
        this.code = code;
        this.title = title;
        this.detail = detail;
        this.sourcePointer = sourcePointer;
        this.sourceParameter = sourceParameter;
        this.meta = meta == null ? null : Collections.unmodifiableMap(meta);
    }

    public static ErrorDataBuilder builder() {
        return new ErrorDataBuilder();
    }

    public String getId() {
        return id;
    }

    public String getAboutLink() {
        return aboutLink;
    }

    public String getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDetail() {
        return detail;
    }

    public String getSourcePointer() {
        return sourcePointer;
    }

    public String getSourceParameter() {
        return sourceParameter;
    }

    public Map<String, Object> getMeta() {
        return meta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ErrorData)) return false;
        ErrorData that = (ErrorData) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(aboutLink, that.aboutLink) &&
                Objects.equals(status, that.status) &&
                Objects.equals(code, that.code) &&
                Objects.equals(title, that.title) &&
                Objects.equals(detail, that.detail) &&
                Objects.equals(sourceParameter, that.sourceParameter) &&
                Objects.equals(sourcePointer, that.sourcePointer) &&
                Objects.equals(meta, that.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, aboutLink, status, code, title, detail, sourceParameter, sourcePointer, meta);
    }

    @Override
    public String toString() {
        return "ErrorData{" +
                "id='" + id + '\'' +
                ", aboutLink='" + aboutLink + '\'' +
                ", status='" + status + '\'' +
                ", code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", detail='" + detail + '\'' +
                ", sourcePointer='" + sourcePointer + '\'' +
                ", sourceParameter='" + sourceParameter + '\'' +
                ", meta=" + meta +
                '}';
    }
}
