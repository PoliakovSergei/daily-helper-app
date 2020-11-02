import {createAsyncThunk, createSlice} from "@reduxjs/toolkit";
import {v4 as uuid} from 'uuid';

const initialState = {
    list: [],
    status: 'idle',
    error: null,
}

export const fetchTasks = createAsyncThunk(
    'tasks/fetchTasks',
    async () => {
        const response = await fetch(
            "http://localhost:8080/tasks/my-tasks");
        return response.json();
    }
)

export const tasksSlice = createSlice({
    name: 'tasks',
    initialState,
    reducers: {
        addTask: {
            reducer(state, action) {
                state.list.push(action.payload);
            },
            prepare(name, text) {
                return {
                    payload: {
                        id: uuid(),
                        endDate: new Date().toLocaleString(),
                        taskName: name,
                        taskDescription: text,
                    }
                }
            }
        },
    },
    extraReducers: {
        [fetchTasks.pending]: (state) => {
            state.status = 'loading'
        },
        [fetchTasks.fulfilled]: (state, action) => {
            state.status = 'succeeded'
            state.list = state.list.concat(action.payload.data)
        },
        [fetchTasks.rejected]: (state, action) => {
            state.status = 'failed'
            state.error = action.error.message
        }
    }
})

export const { addTask, getTasks } = tasksSlice.actions;

export const selectAllTasks = state => state.tasks.list;
export const selectTaskById = (state, taskId) => state.tasks.find(task => task.id === taskId);


export default tasksSlice.reducer;
