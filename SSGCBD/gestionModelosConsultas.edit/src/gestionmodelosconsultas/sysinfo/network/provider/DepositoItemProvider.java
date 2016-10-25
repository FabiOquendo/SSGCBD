/**
 */
package gestionmodelosconsultas.sysinfo.network.provider;


import gestionmodelosconsultas.modeloconsultas.donde.DondeFactory;

import gestionmodelosconsultas.provider.GestionModelosConsultasEditPlugin;

import gestionmodelosconsultas.sysinfo.SysinfoPackage;

import gestionmodelosconsultas.sysinfo.network.Deposito;
import gestionmodelosconsultas.sysinfo.network.NetworkFactory;
import gestionmodelosconsultas.sysinfo.network.NetworkPackage;

import gestionmodelosconsultas.sysinfo.provider.PaqueteItemProvider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link gestionmodelosconsultas.sysinfo.network.Deposito} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DepositoItemProvider extends PaqueteItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DepositoItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addCopiaPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Copia feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCopiaPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Deposito_Copia_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Deposito_Copia_feature", "_UI_Deposito_type"),
				 NetworkPackage.Literals.DEPOSITO__COPIA,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(NetworkPackage.Literals.DEPOSITO__SU_DEPOSITO);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Deposito.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Deposito"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Deposito)object).getNombre();
		return label == null || label.length() == 0 ?
			getString("_UI_Deposito_type") :
			getString("_UI_Deposito_type") + " " + label;
	}
	

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Deposito.class)) {
			case NetworkPackage.DEPOSITO__SU_DEPOSITO:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(NetworkPackage.Literals.DEPOSITO__SU_DEPOSITO,
				 NetworkFactory.eINSTANCE.createDeposito()));

		newChildDescriptors.add
			(createChildParameter
				(NetworkPackage.Literals.DEPOSITO__SU_DEPOSITO,
				 NetworkFactory.eINSTANCE.createDisco()));

		newChildDescriptors.add
			(createChildParameter
				(NetworkPackage.Literals.DEPOSITO__SU_DEPOSITO,
				 NetworkFactory.eINSTANCE.createArmario()));

		newChildDescriptors.add
			(createChildParameter
				(NetworkPackage.Literals.DEPOSITO__SU_DEPOSITO,
				 DondeFactory.eINSTANCE.createDeposito()));

		newChildDescriptors.add
			(createChildParameter
				(NetworkPackage.Literals.DEPOSITO__SU_DEPOSITO,
				 DondeFactory.eINSTANCE.createDisco()));

		newChildDescriptors.add
			(createChildParameter
				(NetworkPackage.Literals.DEPOSITO__SU_DEPOSITO,
				 DondeFactory.eINSTANCE.createArmario()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == SysinfoPackage.Literals.PAQUETE__ELEMENT ||
			childFeature == NetworkPackage.Literals.DEPOSITO__SU_DEPOSITO;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return GestionModelosConsultasEditPlugin.INSTANCE;
	}

}