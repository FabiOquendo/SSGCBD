/**
 */
package gestionmodelosconsultas.modeloconsultas.resultset.resultque.util;

import gestionmodelosconsultas.modeloconsultas.resultset.ElementoModeloResultado;
import gestionmodelosconsultas.modeloconsultas.resultset.ResultElement;

import gestionmodelosconsultas.modeloconsultas.resultset.resultque.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see gestionmodelosconsultas.modeloconsultas.resultset.resultque.ResultquePackage
 * @generated
 */
public class ResultqueAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ResultquePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultqueAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ResultquePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResultqueSwitch<Adapter> modelSwitch =
		new ResultqueSwitch<Adapter>() {
			@Override
			public Adapter caseDocumento(Documento object) {
				return createDocumentoAdapter();
			}
			@Override
			public Adapter caseComunicacion(Comunicacion object) {
				return createComunicacionAdapter();
			}
			@Override
			public Adapter caseResultElement(ResultElement object) {
				return createResultElementAdapter();
			}
			@Override
			public Adapter caseElementoModeloResultado(ElementoModeloResultado object) {
				return createElementoModeloResultadoAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link gestionmodelosconsultas.modeloconsultas.resultset.resultque.Documento <em>Documento</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gestionmodelosconsultas.modeloconsultas.resultset.resultque.Documento
	 * @generated
	 */
	public Adapter createDocumentoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gestionmodelosconsultas.modeloconsultas.resultset.resultque.Comunicacion <em>Comunicacion</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gestionmodelosconsultas.modeloconsultas.resultset.resultque.Comunicacion
	 * @generated
	 */
	public Adapter createComunicacionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gestionmodelosconsultas.modeloconsultas.resultset.ResultElement <em>Result Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gestionmodelosconsultas.modeloconsultas.resultset.ResultElement
	 * @generated
	 */
	public Adapter createResultElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gestionmodelosconsultas.modeloconsultas.resultset.ElementoModeloResultado <em>Elemento Modelo Resultado</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gestionmodelosconsultas.modeloconsultas.resultset.ElementoModeloResultado
	 * @generated
	 */
	public Adapter createElementoModeloResultadoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ResultqueAdapterFactory
