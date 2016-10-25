package pruebamemorandos.view.update.actions;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.jface.dialogs.MessageDialog;
import pruebamemorandos.view.view.ModelFactoryModel;
import pruebamemorandos.view.view.views.*;

public class UpdateAction implements IWorkbenchWindowActionDelegate {
private IWorkbenchWindow window;
public UpdateAction() {
}
public void run(IAction action) {
    ModelFactoryModel model = ModelFactoryModel.getInstance();
     model.update();
    VentanaMemorandoViewPart ventanaMemorandoViewPart = model.getVentanaMemorandoViewPart();
ventanaMemorandoViewPart.updateData();

}
   public void selectionChanged(IAction action, ISelection selection) {
  }
   public void dispose()  {
}
  public void init(IWorkbenchWindow window) {
   this.window = window;
  }
}