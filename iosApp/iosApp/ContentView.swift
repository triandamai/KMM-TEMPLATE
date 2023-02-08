import SwiftUI
import shared

struct ContentView: View {

    @ObservedObject private(set) var viewModel:ViewModel
    
    init(viewModel: ViewModel) {
        self.viewModel = viewModel

    }
	var body: some View {
        HStack(){
            VStack(alignment:.leading,spacing: 10.0){
                List(viewModel.notes, id: \.self,rowContent: { n in
                    Text("\(n.noteName)")
                })
                Button(action: {
                    viewModel.saveNewNote()
                }, label: {
                   Text("Login")
                })
            }
        }
	}
}

extension ContentView{
    class ViewModel: ObservableObject{
        let sdk:NoteSDK
        
        @Published var notes:[NoteModel] = []
        
        init(sdk:NoteSDK){
            self.sdk = sdk
        }
        
        func getAllNotes(){
            self.sdk.getListAllNote(
                completionHandler: {
                    note,error in
                    self.notes = note ?? []
                }
            )
        }
        
        func saveNewNote(){
            self.sdk.insertNewNote(data: NoteModel(noteId: UUID().uuidString, noteName: "INi nama", noteDescription: "INi Deskripsi"),completionHandler: {
                _,err in
                
                self.getAllNotes()
            })
            
        }
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
        ContentView(viewModel: .init(sdk: CreateIOSSDK().createNoteSDK()))
	}
}
