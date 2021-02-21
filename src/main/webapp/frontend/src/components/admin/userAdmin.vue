<template>
	<b-container fluid>
		<!-- User Interface controls -->
		<b-row>
			<b-col lg="6" class="my-1">
				<b-form-group
					label="Sort"
					label-for="sort-by-select"
					label-cols-sm="3"
					label-align-sm="right"
					label-size="sm"
					class="mb-0"
					v-slot="{ ariaDescribedby }"
				>
					<b-input-group size="sm">
						<b-form-select
							id="sort-by-select"
							v-model="sortBy"
							:options="sortOptions"
							:aria-describedby="ariaDescribedby"
							class="w-75"
						>
							<template #first>
								<option value="">-- none --</option>
							</template>
						</b-form-select>

						<b-form-select
							v-model="sortDesc"
							:disabled="!sortBy"
							:aria-describedby="ariaDescribedby"
							size="sm"
							class="w-25"
						>
							<option :value="false">Asc</option>
							<option :value="true">Desc</option>
						</b-form-select>
					</b-input-group>
				</b-form-group>
			</b-col>

			<b-col lg="6" class="my-1">
				<b-form-group
					label="Initial sort"
					label-for="initial-sort-select"
					label-cols-sm="3"
					label-align-sm="right"
					label-size="sm"
					class="mb-0"
				>
					<b-form-select
						id="initial-sort-select"
						v-model="sortDirection"
						:options="['asc', 'desc', 'last']"
						size="sm"
					></b-form-select>
				</b-form-group>
			</b-col>

			<b-col lg="6" class="my-1">
				<b-form-group
					label="Filter"
					label-for="filter-input"
					label-cols-sm="3"
					label-align-sm="right"
					label-size="sm"
					class="mb-0"
				>
					<b-input-group size="sm">
						<b-form-input
							id="filter-input"
							v-model="filter"
							type="search"
							placeholder="Type to Search"
						></b-form-input>

						<b-input-group-append>
							<b-button :disabled="!filter" @click="filter = ''"
								>Clear</b-button
							>
						</b-input-group-append>
					</b-input-group>
				</b-form-group>
			</b-col>

			<b-col lg="6" class="my-1">
				<b-form-group
					v-model="sortDirection"
					label="Filter On"
					description="Leave all unchecked to filter on all data"
					label-cols-sm="3"
					label-align-sm="right"
					label-size="sm"
					class="mb-0"
					v-slot="{ ariaDescribedby }"
				>
					<b-form-checkbox-group
						v-model="filterOn"
						:aria-describedby="ariaDescribedby"
						class="mt-1"
					>
						<b-form-checkbox value="id">Id</b-form-checkbox>
						<b-form-checkbox value="pw">pw</b-form-checkbox>
						<b-form-checkbox value="nickname">nickname</b-form-checkbox>
						<b-form-checkbox value="phonenumber">phonenumber</b-form-checkbox>
						<b-form-checkbox value="birth">birth</b-form-checkbox>
						<b-form-checkbox value="gender">gender</b-form-checkbox>
						<b-form-checkbox value="classification"
							>classification</b-form-checkbox
						>
					</b-form-checkbox-group>
				</b-form-group>
			</b-col>

			<b-col sm="5" md="6" class="my-1">
				<b-form-group
					label="Per page"
					label-for="per-page-select"
					label-cols-sm="6"
					label-cols-md="4"
					label-cols-lg="3"
					label-align-sm="right"
					label-size="sm"
					class="mb-0"
				>
					<b-form-select
						id="per-page-select"
						v-model="perPage"
						:options="pageOptions"
						size="sm"
					></b-form-select>
				</b-form-group>
			</b-col>

			<b-col sm="7" md="6" class="my-1">
				<b-pagination
					v-model="currentPage"
					:total-rows="totalRows"
					:per-page="perPage"
					align="fill"
					size="sm"
					class="my-0"
				></b-pagination>
			</b-col>
		</b-row>

		<!-- Main table element -->
		<div class="tableplace">
			<b-table
				:items="items"
				:fields="fields"
				:current-page="currentPage"
				:per-page="perPage"
				:filter="filter"
				:filter-included-fields="filterOn"
				:sort-by.sync="sortBy"
				:sort-desc.sync="sortDesc"
				:sort-direction="sortDirection"
				stacked="md"
				show-empty
				small
				@filtered="onFiltered"
			>
				<template #cell(name)="row">
					{{ row.value }}
				</template>
			</b-table>
		</div>
		<!-- Info modal -->
		<b-modal
			:id="infoModal.id"
			:title="infoModal.title"
			ok-only
			@hide="resetInfoModal"
		>
			<pre>{{ infoModal.content }}</pre>
		</b-modal>
	</b-container>
</template>

<script>
import { fetchUsers } from '@/api/auth';

export default {
	name: 'userAdmin',
	data() {
		return {
			items: [],
			fields: [
				{
					key: 'id',
					label: '회원아이디',
					class: 'text-center',
					sortable: true,
				},
				{
					key: 'name',
					label: '이름',
					sortable: true,
					class: 'text-center',
				},
				{
					key: 'nickname',
					label: '닉네임',
					sortable: true,
					class: 'text-center',
				},
				{
					key: 'birth',
					label: '생년월일',
					sortable: true,
					class: 'text-center',
				},
				{
					key: 'gender',
					label: '성별',
					sortable: true,
					class: 'text-center',
				},
				{
					key: 'classification',
					label: '권한',
					sortable: true,
					class: 'text-center',
				},
				{
					key: 'pw',
					label: '비밀번호',
					sortable: true,
					// class: 'text-center',
				},
			],
			totalRows: 1,
			currentPage: 1,
			perPage: 5,
			pageOptions: [5, 10, 15, { value: 100, text: 'Show a lot' }],
			sortBy: '',
			sortDesc: false,
			sortDirection: 'asc',
			filter: null,
			filterOn: [],
			infoModal: {
				id: 'info-modal',
				title: '',
				content: '',
			},
		};
	},
	computed: {
		sortOptions() {
			// Create an options list from our fields
			return this.fields
				.filter(f => f.sortable)
				.map(f => {
					return { text: f.label, value: f.key };
				});
		},
	},
	mounted() {
		// Set the initial number of items
		this.totalRows = this.items.length;
	},
	methods: {
		async getAllUsers() {
			try {
				//회원리스트 요청
				const response = await fetchUsers();
				this.items = response.data;
			} catch (error) {
				console.log(error);
				this.logMessage = error.items.data;
			}
		},
		info(item, index, button) {
			this.infoModal.title = `Row index: ${index}`;
			this.infoModal.content = JSON.stringify(item, null, 2);
			this.$root.$emit('bv::show::modal', this.infoModal.id, button);
		},
		resetInfoModal() {
			this.infoModal.title = '';
			this.infoModal.content = '';
		},
		onFiltered(filteredItems) {
			// Trigger pagination to update the number of buttons/pages due to filtering
			this.totalRows = filteredItems.length;
			this.currentPage = 1;
		},
	},
	//화면 실행 시 getAllRooms 함수 실행
	beforeMount() {
		this.getAllUsers();
	},
};
</script>
