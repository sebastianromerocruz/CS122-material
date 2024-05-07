/**
 * Represents a prayer that can be conducted.
 * 
 * @throws VisitationNotAllowedException if the prayer cannot be conducted.
 * 
 * @see VisitationNotAllowedException
 */
interface Prayer {
    void conductPrayer() throws VisitationNotAllowedException;
}