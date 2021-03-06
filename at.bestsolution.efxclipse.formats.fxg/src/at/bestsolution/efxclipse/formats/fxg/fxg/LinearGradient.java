/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package at.bestsolution.efxclipse.formats.fxg.fxg;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Linear Gradient</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.bestsolution.efxclipse.formats.fxg.fxg.LinearGradient#getX <em>X</em>}</li>
 *   <li>{@link at.bestsolution.efxclipse.formats.fxg.fxg.LinearGradient#getY <em>Y</em>}</li>
 *   <li>{@link at.bestsolution.efxclipse.formats.fxg.fxg.LinearGradient#getScaleX <em>Scale X</em>}</li>
 *   <li>{@link at.bestsolution.efxclipse.formats.fxg.fxg.LinearGradient#getRotation <em>Rotation</em>}</li>
 *   <li>{@link at.bestsolution.efxclipse.formats.fxg.fxg.LinearGradient#getSpreadMethod <em>Spread Method</em>}</li>
 *   <li>{@link at.bestsolution.efxclipse.formats.fxg.fxg.LinearGradient#getInterpolationMethod <em>Interpolation Method</em>}</li>
 *   <li>{@link at.bestsolution.efxclipse.formats.fxg.fxg.LinearGradient#getMatrix <em>Matrix</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.bestsolution.efxclipse.formats.fxg.fxg.FxgPackage#getLinearGradient()
 * @model
 * @generated
 */
public interface LinearGradient extends Fill, ContainerElement<GradientEntry> {
	/**
	 * Returns the value of the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>X</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>X</em>' attribute.
	 * @see #setX(Double)
	 * @see at.bestsolution.efxclipse.formats.fxg.fxg.FxgPackage#getLinearGradient_X()
	 * @model
	 * @generated
	 */
	Double getX();

	/**
	 * Sets the value of the '{@link at.bestsolution.efxclipse.formats.fxg.fxg.LinearGradient#getX <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X</em>' attribute.
	 * @see #getX()
	 * @generated
	 */
	void setX(Double value);

	/**
	 * Returns the value of the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Y</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Y</em>' attribute.
	 * @see #setY(Double)
	 * @see at.bestsolution.efxclipse.formats.fxg.fxg.FxgPackage#getLinearGradient_Y()
	 * @model
	 * @generated
	 */
	Double getY();

	/**
	 * Sets the value of the '{@link at.bestsolution.efxclipse.formats.fxg.fxg.LinearGradient#getY <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Y</em>' attribute.
	 * @see #getY()
	 * @generated
	 */
	void setY(Double value);

	/**
	 * Returns the value of the '<em><b>Scale X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scale X</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scale X</em>' attribute.
	 * @see #setScaleX(Double)
	 * @see at.bestsolution.efxclipse.formats.fxg.fxg.FxgPackage#getLinearGradient_ScaleX()
	 * @model
	 * @generated
	 */
	Double getScaleX();

	/**
	 * Sets the value of the '{@link at.bestsolution.efxclipse.formats.fxg.fxg.LinearGradient#getScaleX <em>Scale X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scale X</em>' attribute.
	 * @see #getScaleX()
	 * @generated
	 */
	void setScaleX(Double value);

	/**
	 * Returns the value of the '<em><b>Rotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rotation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rotation</em>' attribute.
	 * @see #setRotation(Double)
	 * @see at.bestsolution.efxclipse.formats.fxg.fxg.FxgPackage#getLinearGradient_Rotation()
	 * @model dataType="at.bestsolution.efxclipse.formats.fxg.fxg.Angle"
	 * @generated
	 */
	Double getRotation();

	/**
	 * Sets the value of the '{@link at.bestsolution.efxclipse.formats.fxg.fxg.LinearGradient#getRotation <em>Rotation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rotation</em>' attribute.
	 * @see #getRotation()
	 * @generated
	 */
	void setRotation(Double value);

	/**
	 * Returns the value of the '<em><b>Spread Method</b></em>' attribute.
	 * The literals are from the enumeration {@link at.bestsolution.efxclipse.formats.fxg.fxg.SpreadMethod}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Spread Method</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Spread Method</em>' attribute.
	 * @see at.bestsolution.efxclipse.formats.fxg.fxg.SpreadMethod
	 * @see #setSpreadMethod(SpreadMethod)
	 * @see at.bestsolution.efxclipse.formats.fxg.fxg.FxgPackage#getLinearGradient_SpreadMethod()
	 * @model
	 * @generated
	 */
	SpreadMethod getSpreadMethod();

	/**
	 * Sets the value of the '{@link at.bestsolution.efxclipse.formats.fxg.fxg.LinearGradient#getSpreadMethod <em>Spread Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Spread Method</em>' attribute.
	 * @see at.bestsolution.efxclipse.formats.fxg.fxg.SpreadMethod
	 * @see #getSpreadMethod()
	 * @generated
	 */
	void setSpreadMethod(SpreadMethod value);

	/**
	 * Returns the value of the '<em><b>Interpolation Method</b></em>' attribute.
	 * The literals are from the enumeration {@link at.bestsolution.efxclipse.formats.fxg.fxg.InterpolationMethod}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interpolation Method</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interpolation Method</em>' attribute.
	 * @see at.bestsolution.efxclipse.formats.fxg.fxg.InterpolationMethod
	 * @see #setInterpolationMethod(InterpolationMethod)
	 * @see at.bestsolution.efxclipse.formats.fxg.fxg.FxgPackage#getLinearGradient_InterpolationMethod()
	 * @model
	 * @generated
	 */
	InterpolationMethod getInterpolationMethod();

	/**
	 * Sets the value of the '{@link at.bestsolution.efxclipse.formats.fxg.fxg.LinearGradient#getInterpolationMethod <em>Interpolation Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interpolation Method</em>' attribute.
	 * @see at.bestsolution.efxclipse.formats.fxg.fxg.InterpolationMethod
	 * @see #getInterpolationMethod()
	 * @generated
	 */
	void setInterpolationMethod(InterpolationMethod value);

	/**
	 * Returns the value of the '<em><b>Matrix</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Matrix</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Matrix</em>' containment reference.
	 * @see #setMatrix(Matrix)
	 * @see at.bestsolution.efxclipse.formats.fxg.fxg.FxgPackage#getLinearGradient_Matrix()
	 * @model containment="true"
	 * @generated
	 */
	Matrix getMatrix();

	/**
	 * Sets the value of the '{@link at.bestsolution.efxclipse.formats.fxg.fxg.LinearGradient#getMatrix <em>Matrix</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Matrix</em>' containment reference.
	 * @see #getMatrix()
	 * @generated
	 */
	void setMatrix(Matrix value);

} // LinearGradient
