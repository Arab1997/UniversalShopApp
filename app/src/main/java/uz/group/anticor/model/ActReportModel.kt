package uz.group.anticor.model

data class ActReportModel(
    var saldo: ActItemModel,
    var table: List<ActItemModel>,
    var oborot: ActItemModel,
    var dolg: ActItemModel
)